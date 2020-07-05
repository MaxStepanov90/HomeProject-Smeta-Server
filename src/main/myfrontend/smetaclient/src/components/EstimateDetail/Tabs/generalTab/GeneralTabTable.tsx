import React from "react";
import {Button} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTrash} from "@fortawesome/free-solid-svg-icons";
import {IEstimateDetail} from "../../../../interfaces/IEstimateDetail";
import {useDispatch} from "react-redux";
import {deleteEstimateDetail} from "../../../../service/actions/estimateDetailActions";
import Table from "react-bootstrap/Table";

type TabGeneralTableProps = {
    estimateDetails: IEstimateDetail[],
}
export const GeneralTabTable: React.FC<TabGeneralTableProps> = (
    {estimateDetails}
) => {
    const dispatch = useDispatch()

    return (
        <Table responsive="sm" bordered>
            <thead>
            <tr>
                <th>Категория</th>
                <th>Наименование</th>
                <th>Ед</th>
                <th>Кол</th>
                <th>Цена</th>
                <th>Стоим</th>
                <th>Цена Клиента</th>
                <th>Стоим. Клиента</th>
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
                        <td>{estimateDetail.category}</td>
                        <td>{estimateDetail.name}</td>
                        <td>{estimateDetail.unit}</td>
                        <td>{estimateDetail.quantity}</td>
                        <td>{estimateDetail.price}</td>
                        <td>{estimateDetail.cost}</td>
                        <td>{estimateDetail.priceClient}</td>
                        <td>{estimateDetail.costClient}</td>
                        <td className="text-center">
                            <Button
                                variant="outline-danger"
                                    onClick={() => dispatch(deleteEstimateDetail(estimateDetail.id))}>
                                <FontAwesomeIcon icon={faTrash}/>
                            </Button>
                        </td>
                    </tr>
                ))}
            </tbody>
        </Table>
    )
}
