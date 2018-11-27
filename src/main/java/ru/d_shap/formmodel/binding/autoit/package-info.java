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
/**
 * <p>
 * Form model autoit binding is a form model binding implementation for AutoIt.
 * </p>
 * <p>
 * Form model autoit binding is a wrapper for AutoIt scripts. It provides facilities to describe
 * the application's GUI, to bind this description with the application and to automate the application
 * through the binded description.
 * </p>
 * <p>
 * The benefit is in enhancing script maintenance and reducing code duplication. So if the GUI changes,
 * the script themselves don’t need to change, only the GUI definition needs to change. Subsequently
 * all changes to support that new GUI are located in one place.
 * </p>
 * <p>
 * The application's GUI is described in the form definition XML. Then this form definition is binded
 * with the application's GUI and the result of this binding is a binded form. Binded elements can be
 * obtained by the application from this binded form. Script uses this binded elements to automate the
 * application.
 * </p>
 */
package ru.d_shap.formmodel.binding.autoit;
