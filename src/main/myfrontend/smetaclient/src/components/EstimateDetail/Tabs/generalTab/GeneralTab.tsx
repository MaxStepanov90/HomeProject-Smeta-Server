import React, {Fragment} from "react";
import {GeneralTabTable} from "./GeneralTabTable";
import {GeneralTabDescription} from "./GeneralTabDescription";
import {IEstimateDetail} from "../../../../interfaces/IEstimateDetail";
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPlusSquare} from "@fortawesome/free-solid-svg-icons";
import {IEstimate} from "../../../../interfaces/IEstimate.";

type TabGeneralProps = {
    estimate: IEstimate,
    sumOfWorks: number,
    sumOfMaterials: number,
    estimateDetails: IEstimateDetail[],
}
export const GeneralTab: React.FC<TabGeneralProps> = (
    {
        estimate, sumOfWorks, sumOfMaterials, estimateDetails
    }) => {

    return (
        <Fragment>
            <div className="container-fluid my-4">
                <GeneralTabDescription estimateName={estimate.name}
                                       sumOfWorks={sumOfWorks}
                                       sumOfMaterials={sumOfMaterials}
                />
                <div className="my-2">
                    <Link to={{pathname: "/addEstimateDetail", state: {estimateId: estimate.id}}}
                          className="btn btn-sm btn-primary">
                        <FontAwesomeIcon icon={faPlusSquare}/>&nbsp;
                        Добавить позицию
                    </Link>
                </div>
                <div className="my-2">
                    <GeneralTabTable estimateDetails={estimateDetails}/>
                </div>
            </div>
        </Fragment>

    )
}