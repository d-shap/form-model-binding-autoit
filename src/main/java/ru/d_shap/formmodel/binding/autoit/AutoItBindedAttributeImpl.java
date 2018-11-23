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

/**
 * The AutoIt binded attribute implementation.
 *
 * @author Dmitry Shapovalov
 */
final class AutoItBindedAttributeImpl implements AutoItBindedAttribute {

    private final String _name;

    private final Object _value;

    AutoItBindedAttributeImpl(final String name, final Object value) {
        super();
        _name = name;
        _value = value;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public Object getValue() {
        return _value;
    }

}
