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

import autoitx4java.AutoItX;

/**
 * The AutoIt binded form implementation.
 *
 * @author Dmitry Shapovalov
 */
final class AutoItBindedFormImpl implements AutoItBindedForm {

    private final AutoItX _autoItX;

    private final String _windowTitle;

    private final String _windowText;

    AutoItBindedFormImpl(final AutoItX autoItX, final String windowTitle, final String windowText) {
        super();
        _autoItX = autoItX;
        _windowTitle = windowTitle;
        _windowText = windowText;
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
    public void activate() {
        _autoItX.winActivate(_windowTitle, _windowText);
        _autoItX.winWaitActive(_windowTitle, _windowText);
    }

    @Override
    public void close() {
        _autoItX.winClose(_windowTitle, _windowText);
        _autoItX.winWaitClose(_windowTitle, _windowText);
    }

    @Override
    public void kill() {
        _autoItX.winKill(_windowTitle, _windowText);
    }

    @Override
    public String getProcessId() {
        return _autoItX.winGetProcess(_windowTitle, _windowText);
    }

    @Override
    public void sendKeys(final String text) {
        sendKeys(text, false);
    }

    @Override
    public void sendKeys(final String text, final boolean sendRawKeys) {
        _autoItX.send(text, sendRawKeys);
    }

}
