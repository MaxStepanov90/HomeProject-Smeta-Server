import React from "react";
import {Col} from "react-bootstrap";

type TabDescriptionColumnProps = {
    title: string,
    dataOfWorks: number | string,
    dataOfMaterials: number | string,
    dataOfAll: number | string
}
export const TabDescriptionColumn: React.FC<TabDescriptionColumnProps> = (
    {title, dataOfWorks, dataOfMaterials, dataOfAll}
) => {

    return (
        <Col>
            <div className="row">
                {title}
            </div>
            <div className="row">
                {dataOfWorks}
            </div>
            <div className="row">
                {dataOfMaterials}
            </div>
            <div className="row">
                {dataOfAll}
            </div>
        </Col>
    )
}