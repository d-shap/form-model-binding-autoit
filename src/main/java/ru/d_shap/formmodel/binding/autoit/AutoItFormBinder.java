///////////////////////////////////////////////////////////////////////////////////////////////////
// Form model autoit binding is a form model implementation for AutoIt.
// Copyright (C) 2018 Dmitry Shapovalov.
//
// This file is part of form model autoit binding.
//
// Form model autoit binding is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Form model autoit binding is distributed in the hope that it will be useful,
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

import ru.d_shap.formmodel.binding.FormBinder;
import ru.d_shap.formmodel.definition.ElementDefinition;
import ru.d_shap.formmodel.definition.FormDefinition;
import ru.d_shap.formmodel.definition.FormDefinitions;
import ru.d_shap.formmodel.definition.FormReferenceDefinition;

import autoitx4java.AutoItX;

/**
 * AutoIt form binder.
 *
 * @author Dmitry Shapovalov
 */
public final class AutoItFormBinder extends FormBinder<AutoItForm, AutoItElement, AutoItFormReference, AutoItData> {

    private final AutoItX _autoItX;

    private FormDefinition _formDefinition;

    /**
     * Create new object.
     *
     * @param formDefinitions form definitions.
     * @param autoItX         AutoIt facade.
     */
    public AutoItFormBinder(final FormDefinitions formDefinitions, final AutoItX autoItX) {
        super(formDefinitions);
        _autoItX = autoItX;
    }

    @Override
    protected AutoItForm createBindedFormInstance(final FormDefinition formDefinition) {
        _formDefinition = formDefinition;
        return new AutoItForm(_autoItX, formDefinition);
    }

    @Override
    protected List<AutoItData> createBindingDataInstances(final AutoItElement parentElement, final String lookup) {
        List<AutoItData> result = new ArrayList<>();
        AutoItData autoItData = new AutoItData(_formDefinition.getAdditionalAttributes().get("title"), lookup);
        result.add(autoItData);
        return result;
    }

    @Override
    protected AutoItElement createBindedElementInstance(final ElementDefinition elementDefinition, final AutoItData bindingData) {
        return new AutoItElement(_autoItX, elementDefinition, bindingData);
    }

    @Override
    protected AutoItFormReference createBindedFormReferenceInstance(final FormReferenceDefinition formReferenceDefinition) {
        return new AutoItFormReference(formReferenceDefinition);
    }

    /**
     * Bind current form with the form definition.
     *
     * @param formId the form ID.
     * @return Binded form.
     */
    public AutoItForm bind(final String formId) {
        return doBind(formId);
    }

}
