///////////////////////////////////////////////////////////////////////////////////////////////////
// Form model autoit binding is a form model binding implementation for AutoIt.
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

import autoitx4java.AutoItX;

/**
 * The AutoIt binded form.
 *
 * @author Dmitry Shapovalov
 */
public interface AutoItBindedForm {

    /**
     * Get the AutoIt.
     *
     * @return the AutoIt.
     */
    AutoItX getAutoIt();

    /**
     * Get the title of the window to access.
     *
     * @return the title of the window to access.
     */
    String getWindowTitle();

    /**
     * Get the text of the window to access.
     *
     * @return the text of the window to access.
     */
    String getWindowText();

}
