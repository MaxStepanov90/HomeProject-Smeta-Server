import React from "react";
import {IEstimateDetail} from "../../../../interfaces/IEstimateDetail";
import Table from "react-bootstrap/Table";

type TabClientTableProps = {
    estimateDetails: IEstimateDetail []
}

export const ClientTabTable: React.FC<TabClientTableProps> = ({estimateDetails}) => {

    return (
        <Table responsive bordered>
            <thead>
            <tr>
                <th>Наименование</th>
                <th>Ед</th>
                <th>Кол</th>
                <th>Цена</th>
                <th>Стоим</th>
            </tr>
            </thead>
            <tbody>
            {estimateDetails.length === 0 ?
                <tr>
                    <td align="left" colSpan={12}>Нет доступных позиций.</td>
                </tr> :
                estimateDetails.map((estimateDetail: IEstimateDetail) => (
                    <tr key={estimateDetail.id}
                        style={estimateDetail.category === "материалы" ?
                            {background: "#FFFACD"} : {background: "#AFEEEE"}}
                    >
                        <td>{estimateDetail.name}</td>
                        <td>{estimateDetail.unit}</td>
                        <td>{estimateDetail.quantity}</td>
                        <td>{estimateDetail.priceClient}</td>
                        <td>{estimateDetail.costClient}</td>
                    </tr>
                ))}
            </tbody>
        </Table>
    )
}