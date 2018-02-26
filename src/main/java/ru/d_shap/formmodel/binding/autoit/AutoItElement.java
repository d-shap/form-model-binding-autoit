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

import ru.d_shap.formmodel.binding.BindedElement;
import ru.d_shap.formmodel.definition.ElementDefinition;

import autoitx4java.AutoItX;

/**
 * AutoIt element.
 *
 * @author Dmitry Shapovalov
 */
public final class AutoItElement extends BindedElement<AutoItElement, AutoItFormReference, AutoItData> {

    private final AutoItX _autoItX;

    AutoItElement(final AutoItX autoItX, final ElementDefinition elementDefinition, final AutoItData autoItData) {
        super(elementDefinition, autoItData);
        _autoItX = autoItX;
    }

    /**
     * Click on the current element.
     */
    public void click() {
        _autoItX.controlClick(getBindingData().getAppName(), "", getBindingData().getId());
    }

    /**
     * Get the current element's text.
     *
     * @return the current element's text.
     */
    public String getText() {
        return _autoItX.controlGetText(getBindingData().getAppName(), "", getBindingData().getId());
    }

}
