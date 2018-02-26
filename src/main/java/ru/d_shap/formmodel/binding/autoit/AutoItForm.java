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

import ru.d_shap.formmodel.binding.BindedForm;
import ru.d_shap.formmodel.definition.FormDefinition;

import autoitx4java.AutoItX;

/**
 * AutoIt form.
 *
 * @author Dmitry Shapovalov
 */
public final class AutoItForm extends BindedForm<AutoItElement, AutoItFormReference, AutoItData> {

    private final AutoItX _autoItX;

    AutoItForm(final AutoItX autoItX, final FormDefinition formDefinition) {
        super(formDefinition);
        _autoItX = autoItX;
    }

    /**
     * Activate the current window.
     */
    public void activateWindow() {
        String title = getFormDefinition().getAdditionalAttribute("title");
        _autoItX.winActivate(title);
        _autoItX.winWaitActive(title);
    }

}
