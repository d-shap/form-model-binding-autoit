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
 * The AutoIt binded element implementation.
 *
 * @author Dmitry Shapovalov
 */
final class AutoItBindedElementImpl implements AutoItBindedElement {

    private final AutoItX _autoItX;

    private final String _windowTitle;

    private final String _windowText;

    private final String _controlId;

    AutoItBindedElementImpl(final AutoItX autoItX, final String windowTitle, final String windowText, final String controlId) {
        super();
        _autoItX = autoItX;
        _windowTitle = windowTitle;
        _windowText = windowText;
        _controlId = controlId;
    }

    @Override
    public AutoItX getAutoIt() {
        return _autoItX;
    }

    @Override
    public String getWindowTitle() {
        return _windowTitle;
    }

    @Override
    public String getWindowText() {
        return _windowText;
    }

    @Override
    public String getControlId() {
        return _controlId;
    }

    @Override
    public boolean hasAttribute(final String name) {
        return AutoItBindedElementAttributes.hasAttribute(name);
    }

    @Override
    public Object getAttribute(final String name) {
        return AutoItBindedElementAttributes.getAttribute(_autoItX, _windowTitle, _windowText, _controlId, name);
    }

    @Override
    public boolean isBooleanAttribute(final String name) {
        return (Boolean) getAttribute(name);
    }

    @Override
    public int getIntAttribute(final String name) {
        return (Integer) getAttribute(name);
    }

    @Override
    public String getStringAttribute(final String name) {
        Object value = getAttribute(name);
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

    @Override
    public boolean isVisible() {
        return _autoItX.controlCommandIsVisible(_windowTitle, _windowText, _controlId);
    }

    @Override
    public boolean isEnabled() {
        return _autoItX.controlCommandIsEnabled(_windowTitle, _windowText, _controlId);
    }

    @Override
    public int getX() {
        return _autoItX.controlGetPosX(_windowTitle, _windowText, _controlId);
    }

    @Override
    public int getY() {
        return _autoItX.controlGetPosY(_windowTitle, _windowText, _controlId);
    }

    @Override
    public int getWidth() {
        return _autoItX.controlGetPosWidth(_windowTitle, _windowText, _controlId);
    }

    @Override
    public int getHeight() {
        return _autoItX.controlGetPosHeight(_windowTitle, _windowText, _controlId);
    }

    @Override
    public void focus() {
        _autoItX.controlFocus(_windowTitle, _windowText, _controlId);
    }

    @Override
    public void click() {
        click(AutoItMouseButton.LEFT, 1, getWidth() / 2, getHeight() / 2);
    }

    @Override
    public void click(final AutoItMouseButton mouseButton) {
        click(mouseButton, 1, getWidth() / 2, getHeight() / 2);
    }

    @Override
    public void click(final AutoItMouseButton mouseButton, final int clicks) {
        click(mouseButton, clicks, getWidth() / 2, getHeight() / 2);
    }

    @Override
    public void click(final AutoItMouseButton mouseButton, final int clicks, final int xPos, final int yPos) {
        _autoItX.controlClick(_windowTitle, _windowText, _controlId, mouseButton.getValue(), clicks, xPos, yPos);
    }

    @Override
    public void isChecked() {
        _autoItX.controlCommandIsChecked(_windowTitle, _windowText, _controlId);
    }

    @Override
    public void check() {
        _autoItX.controlCommandCheck(_windowTitle, _windowText, _controlId);
    }

    @Override
    public void uncheck() {
        _autoItX.controlCommandUncheck(_windowTitle, _windowText, _controlId);
    }

    @Override
    public String getText() {
        return _autoItX.controlGetText(_windowTitle, _windowText, _controlId);
    }

    @Override
    public void setText(final String text) {
        _autoItX.ControlSetText(_windowTitle, _windowText, _controlId, text);
    }

    @Override
    public void sendKeys(final String text) {
        sendKeys(text, false);
    }

    @Override
    public void sendKeys(final String text, final boolean sendRawKeys) {
        _autoItX.controlSend(_windowTitle, _windowText, _controlId, text, sendRawKeys);
    }

}
