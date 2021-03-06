/**
 * Copyright © 2002 Instituto Superior Técnico
 *
 * This file is part of FenixEdu Academic.
 *
 * FenixEdu Academic is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FenixEdu Academic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FenixEdu Academic.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.fenixedu.academic.ui.renderers.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.comparators.ReverseComparator;
import org.fenixedu.academic.domain.ExecutionYear;
import org.fenixedu.academic.domain.interfaces.HasDegreeCurricularPlan;
import org.fenixedu.bennu.core.domain.Bennu;

import pt.ist.fenixWebFramework.rendererExtensions.converters.DomainObjectKeyConverter;
import pt.ist.fenixWebFramework.renderers.DataProvider;
import pt.ist.fenixWebFramework.renderers.components.converters.Converter;

public class ExecutionYearsForDegreeCurricularPlanProvider implements DataProvider {

    @Override
    public Object provide(Object source, Object currentValue) {
        HasDegreeCurricularPlan bean = (HasDegreeCurricularPlan) source;
        return getExecutionYears(bean);
    }

    public static List<ExecutionYear> getExecutionYears(HasDegreeCurricularPlan bean) {
        List<ExecutionYear> executionYears = new ArrayList<ExecutionYear>();
        for (ExecutionYear year : Bennu.getInstance().getExecutionYearsSet()) {
            if (year.isInclusivelyBetween(bean.getDegreeCurricularPlan().getInauguralExecutionYear(), bean
                    .getDegreeCurricularPlan().getLastExecutionYear())) {
                executionYears.add(year);
            }
        }
        Collections.sort(executionYears, new ReverseComparator());
        return executionYears;
    }

    @Override
    public Converter getConverter() {
        return new DomainObjectKeyConverter();
    }

}
