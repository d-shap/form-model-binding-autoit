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
package ru.d_shap.fm.formmodel.binding.autoit;

import ru.d_shap.fm.formmodel.binding.model.BindedForm;

import autoitx4java.AutoItX;

/**
 * The AutoIt binded form.
 *
 * @author Dmitry Shapovalov
 */
public interface AutoItBindedForm extends BindedForm {

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
     * Activate the window to access.
     */
    void activate();

    /**
     * Close the window.
     */
    void close();

    /**
     * Forces the window to close.
     */
    void kill();

    /**
     * Get the Process ID (PID) associated with the window.
     *
     * @return the Process ID (PID) associated with the window.
     */
    String getProcessId();

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
