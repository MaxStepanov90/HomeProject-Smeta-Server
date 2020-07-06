import React from "react";
import Col from "react-bootstrap/Col";

type TabDescriptionColumnProps = {
    title: string,
    dataOfWorks: number | string,
    dataOfMaterials: number | string,
}
export const TabDescriptionColumn: React.FC<TabDescriptionColumnProps> = (
    {title, dataOfWorks, dataOfMaterials}
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
        </Col>
    )
}