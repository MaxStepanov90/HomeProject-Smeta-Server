import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTrash} from "@fortawesome/free-solid-svg-icons";
import Button from "react-bootstrap/Button";
import {deleteEstimate} from "../../../service/actions/estimateActions";
import React, {Fragment} from "react";
import {IEstimate} from "../../../interfaces/IEstimate.";
import {useDispatch} from "react-redux";

type EstimateItemProps = {
    estimate: IEstimate
}
export const EstimateItem: React.FC<EstimateItemProps> = ({estimate}) => {

    const dispatch = useDispatch()

    return (
        <Fragment>
            <tr>
                <td>
                    <Link to={{
                        pathname: "/estimate/" + estimate.id,
                        state: {estimateName: estimate.name}
                    }}
                          className="text-dark">
                        {estimate.name}
                    </Link>
                </td>
                <td>{estimate.cost}</td>
                <td>{estimate.performance}</td>
                <td>{estimate.payment}</td>
                <td>{estimate.notPayment}</td>
                <td className="text-center">
                    <Button variant="outline-danger"
                            onClick={() => dispatch(deleteEstimate(estimate.id))}>
                        <FontAwesomeIcon icon={faTrash}/>
                    </Button>
                </td>
            </tr>
        </Fragment>
    )
}