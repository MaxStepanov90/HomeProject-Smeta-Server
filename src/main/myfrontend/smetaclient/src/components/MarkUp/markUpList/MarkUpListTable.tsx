import React from "react";
import Table from "react-bootstrap/Table";
import {Link} from "react-router-dom";
import {IMarkUp} from "../../../interfaces/IMarkUp";

type MarkUpListTableProps = {
    markUps: IMarkUp[];
}

export const MarkUpListTable: React.FC<MarkUpListTableProps> = ({markUps}) => {

    return (
        <Table responsive="sm" bordered>
            <thead>
            <tr>
                <th>Категория</th>
                <th>Процент наценки</th>
            </tr>
            </thead>
            <tbody>
            {markUps.length === 0 ?
                <tr>
                    <td align="left" colSpan={12}>Нет доступных наценок.</td>
                </tr> :
                markUps.map((markUp: IMarkUp) => (
                    <tr key={markUp.id}>
                        <td>
                            <Link to={"markUp/"+markUp.id} className="text-dark">
                                {markUp.markUpName}
                            </Link>
                        </td>
                        <td>{markUp.markUpPercent}</td>
                    </tr>
                ))
            }
            </tbody>
        </Table>
    )
}

