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

import ru.d_shap.formmodel.binding.model.BindedElement;

import autoitx4java.AutoItX;

/**
 * The AutoIt binded element.
 *
 * @author Dmitry Shapovalov
 */
public interface AutoItBindedElement extends BindedElement {

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

    /**
     * Get the control ID to interact with.
     *
     * @return the control ID to interact with.
     */
    String getControlId();

    /**
     * Check if the control has the specified attribute.
     *
     * @param name the specified attribute.
     *
     * @return true if the control has the specified attribute.
     */
    boolean hasAttribute(String name);

    /**
     * Get the value of the specified attribute.
     *
     * @param name the specified attribute.
     *
     * @return the value of the specified attribute.
     */
    Object getAttribute(String name);

    /**
     * Click on the control.
     *
     * @return true if success.
     */
    boolean click();

    /**
     * Click on the control.
     *
     * @param button the button to click, "left", "right" or "middle".
     *
     * @return true if success.
     */
    boolean click(String button);

    /**
     * Click on the control.
     *
     * @param button the button to click, "left", "right" or "middle".
     * @param clicks the number of times to click.
     *
     * @return true if success.
     */
    boolean click(String button, int clicks);

    /**
     * Click on the control.
     *
     * @param button the button to click, "left", "right" or "middle".
     * @param clicks the number of times to click.
     * @param x      the x position to click within the control.
     * @param y      the y position to click within the control.
     *
     * @return true if success.
     */
    boolean click(String button, int clicks, int x, int y);

    /**
     * Checks whether radio or checkbox is checked.
     *
     * @return true if checked.
     */
    boolean isChecked();

    /**
     * Check radio or checkbox.
     */
    void check();

    /**
     * Uncheck radio or checkbox.
     */
    void uncheck();

    /**
     * Get the text from the control.
     *
     * @return the text from the control.
     */
    String getText();

}
