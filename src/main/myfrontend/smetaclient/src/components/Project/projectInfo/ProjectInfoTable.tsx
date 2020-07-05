import React, {Fragment} from "react";
import Table from "react-bootstrap/Table";
import {ProjectInfoButtonGroup} from "./ProjectInfoButtonGroup";
import {IEstimate} from "../../../interfaces/IEstimate.";
import {EstimateItem} from "./EstimateItem";

type EstimatesTableProps = {
    estimates: IEstimate[];
    projectId: number;
}

export const ProjectInfoTable: React.FC<EstimatesTableProps> = ({estimates, projectId}) => {

    return (
        <Fragment>
            <ProjectInfoButtonGroup projectId={projectId}/>
            <Table responsive="sm" bordered>
                <thead>
                <tr>
                    <th>Смета</th>
                    <th>Стоимость</th>
                    <th>Выполнено</th>
                    <th>Оплачено</th>
                    <th>Итого</th>
                </tr>
                </thead>
                <tbody>
                {estimates.length === 0 ?
                    <tr>
                        <td align="left" colSpan={12}>Нет доступных смет.</td>
                    </tr> :
                    estimates.map((estimate: IEstimate) => (
                        <EstimateItem key={estimate.id}
                                      estimate={estimate}/>
                    ))
                }
                </tbody>
            </Table>
        </Fragment>
    )
}