/*
 * Copyright (C) 2020-2022. Huawei Technologies Co., Ltd. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nova.hetu.olk.operator;

import io.prestosql.operator.DriverContext;
import io.prestosql.operator.Operator;
import io.prestosql.operator.OperatorFactory;
import io.prestosql.spi.plan.PlanNodeId;
import io.prestosql.spi.type.Type;

import java.util.List;

public abstract class AbstractOmniOperatorFactory
        implements OperatorFactory
{
    protected int operatorId;

    protected List<Type> sourceTypes;

    protected PlanNodeId planNodeId;

    @Override
    public abstract Operator createOperator(DriverContext driverContext);

    @Override
    public abstract void noMoreOperators();

    @Override
    public abstract OperatorFactory duplicate();

    @Override
    public boolean isExtensionOperatorFactory()
    {
        return true;
    }

    @Override
    public List<Type> getSourceTypes()
    {
        return sourceTypes;
    }

    public int getOperatorId()
    {
        return operatorId;
    }

    public PlanNodeId getPlanNodeId()
    {
        return planNodeId;
    }
}
