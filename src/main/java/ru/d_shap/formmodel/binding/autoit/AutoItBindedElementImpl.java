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
        return false;
    }

    @Override
    public Object getAttribute(final String name) {
        return null;
    }

    @Override
    public void click() {
        _autoItX.controlClick(_windowTitle, _windowText, _controlId);
    }

    @Override
    public String getText() {
        return _autoItX.controlGetText(_windowTitle, _windowText, _controlId);
    }

}
