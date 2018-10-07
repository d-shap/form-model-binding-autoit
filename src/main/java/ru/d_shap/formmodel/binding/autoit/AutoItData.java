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
 * Data for AutoIt element.
 *
 * @author Dmitry Shapovalov
 */
public final class AutoItData {

    private final String _appName;

    private final String _id;

    AutoItData(final String appName, final String id) {
        super();
        _appName = appName;
        _id = id;
    }

    /**
     * Get the application name.
     *
     * @return the application name.
     */
    public String getAppName() {
        return _appName;
    }

    /**
     * Get the current element ID.
     *
     * @return the current element ID.
     */
    public String getId() {
        return _id;
    }

}
