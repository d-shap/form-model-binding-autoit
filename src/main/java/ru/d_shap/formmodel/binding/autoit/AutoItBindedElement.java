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
     * Get the control's ID to interact with.
     *
     * @return the control's ID to interact with.
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
     * Get the value of the control's attribute.
     *
     * @param name the control's attribute name.
     *
     * @return the value of the control's attribute.
     */
    Object getAttribute(String name);

    /**
     * Get the value of the control's attribute as boolean.
     *
     * @param name the control's attribute name.
     *
     * @return the value of the control's attribute as boolean.
     */
    boolean isBooleanAttribute(String name);

    /**
     * Get the value of the control's attribute as int.
     *
     * @param name the control's attribute name.
     *
     * @return the value of the control's attribute as int.
     */
    int getIntAttribute(String name);

    /**
     * Get the value of the control's attribute as string.
     *
     * @param name the control's attribute name.
     *
     * @return the value of the control's attribute as string.
     */
    String getStringAttribute(String name);

    /**
     * Check if the control is visible.
     *
     * @return true if the control is visible.
     */
    boolean isVisible();

    /**
     * Check if the control is enabled.
     *
     * @return true if the control is enabled.
     */
    boolean isEnabled();

    /**
     * Get the control's position X relative to it's window.
     *
     * @return the control's position X relative to it's window.
     */
    int getX();

    /**
     * Get the control position Y relative to it's window.
     *
     * @return the control position Y relative to it's window.
     */
    int getY();

    /**
     * Get the control's width.
     *
     * @return the control's width.
     */
    int getWidth();

    /**
     * Get the control's height.
     *
     * @return the control's height.
     */
    int getHeight();

    /**
     * Sets input focus to the control.
     */
    void focus();

    /**
     * Click on the control.
     */
    void click();

    /**
     * Click on the control.
     *
     * @param mouseButton the button to click.
     */
    void click(AutoItMouseButton mouseButton);

    /**
     * Click on the control.
     *
     * @param mouseButton the button to click.
     * @param clicks      the number of times to click.
     */
    void click(AutoItMouseButton mouseButton, int clicks);

    /**
     * Click on the control.
     *
     * @param mouseButton the button to click.
     * @param clicks      the number of times to click.
     * @param xPos        the x position to click within the control.
     * @param yPos        the y position to click within the control.
     */
    void click(AutoItMouseButton mouseButton, int clicks, int xPos, int yPos);

    /**
     * Checks whether radio or checkbox is checked.
     */
    void isChecked();

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

    /**
     * Set the text of the control.
     *
     * @param text the text of the control.
     */
    void setText(String text);

    /**
     * Send the characters to the control.
     *
     * @param text the characters to send.
     */
    void sendKeys(String text);

    /**
     * Send the characters to the control.
     *
     * @param text        the characters to send.
     * @param sendRawKeys true if characters are sended as it is, without no processing.
     */
    void sendKeys(String text, boolean sendRawKeys);

}
