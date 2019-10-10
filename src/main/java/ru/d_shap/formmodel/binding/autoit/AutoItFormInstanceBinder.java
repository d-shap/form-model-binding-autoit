///////////////////////////////////////////////////////////////////////////////////////////////////
// Form model AutoIt binding is a form model binding implementation for AutoIt.
// Copyright (C) 2018 Dmitry Shapovalov.
//
// This file is part of form model AutoIt binding.
//
// Form model AutoIt binding is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Form model AutoIt binding is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.formmodel.binding.autoit;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ru.d_shap.formmodel.binding.FormInstanceBinder;
import ru.d_shap.formmodel.binding.model.BindedAttribute;
import ru.d_shap.formmodel.binding.model.BindedElement;
import ru.d_shap.formmodel.binding.model.BindedForm;
import ru.d_shap.formmodel.binding.model.BindingSource;
import ru.d_shap.formmodel.definition.model.AttributeDefinition;
import ru.d_shap.formmodel.definition.model.ElementDefinition;
import ru.d_shap.formmodel.definition.model.FormDefinition;

import autoitx4java.AutoItX;

/**
 * Form instance binder AutoIt implementation.
 *
 * @author Dmitry Shapovalov
 */
public final class AutoItFormInstanceBinder implements FormInstanceBinder {

    /**
     * Create new object.
     */
    public AutoItFormInstanceBinder() {
        super();
    }

    @Override
    public void preBind(final BindingSource bindingSource, final FormDefinition formDefinition) {
        // Ignore
    }

    @Override
    public void postBind(final BindingSource bindingSource, final FormDefinition formDefinition, final Document document) {
        // Ignore
    }

    @Override
    public BindedForm bindFormDefinition(final BindingSource bindingSource, final BindedForm lastBindedForm, final BindedElement lastBindedElement, final Element parentElement, final FormDefinition formDefinition) {
        AutoItX autoItX = ((AutoItBindingSource) bindingSource).getAutoIt();
        String windowTitle = ((AutoItBindingSource) bindingSource).getWindowTitle();
        String windowText = ((AutoItBindingSource) bindingSource).getWindowText();

        AutoItBindedForm autoItBindedForm = new AutoItBindedFormImpl(autoItX, windowTitle, windowText);
        autoItBindedForm.activate();
        return autoItBindedForm;
    }

    @Override
    public List<BindedElement> bindElementDefinition(final BindingSource bindingSource, final BindedForm lastBindedForm, final BindedElement lastBindedElement, final Element parentElement, final ElementDefinition elementDefinition) {
        AutoItX autoItX = ((AutoItBindedForm) lastBindedForm).getAutoIt();
        String windowTitle = ((AutoItBindedForm) lastBindedForm).getWindowTitle();
        String windowText = ((AutoItBindedForm) lastBindedForm).getWindowText();
        String controlId = elementDefinition.getLookup();

        List<BindedElement> result = new ArrayList<>();
        String controlHandle = autoItX.controlGetHandle(windowTitle, windowText, controlId);
        int errorCode = autoItX.getError();
        if (!"".equals(controlHandle) && errorCode == 0) {
            AutoItBindedElement autoItBindedElement = new AutoItBindedElementImpl(autoItX, windowTitle, windowText, controlId);
            result.add(autoItBindedElement);
        }
        return result;
    }

    @Override
    public BindedAttribute bindAttributeDefinition(final BindingSource bindingSource, final BindedForm lastBindedForm, final BindedElement lastBindedElement, final Element parentElement, final AttributeDefinition attributeDefinition) {
        String attributeName = attributeDefinition.getLookup();
        if (((AutoItBindedElement) lastBindedElement).hasAttribute(attributeName)) {
            Object attributeValue = ((AutoItBindedElement) lastBindedElement).getAttribute(attributeName);
            return new AutoItBindedAttributeImpl(attributeName, attributeValue);
        } else {
            return null;
        }
    }

}
