import React from "react";
import {TabDescriptionColumn} from "../../../Generic/TabDescriptionColumn";
import {DescriptionRaw} from "../../../Generic/DescrpirtionRaw";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

type TabGeneralDescriptionProps = {
    estimateName: string,
    sumOfWorks: number,
    sumOfMaterials: number,
}
export const GeneralTabDescription: React.FC<TabGeneralDescriptionProps> = (
    {
        estimateName, sumOfWorks, sumOfMaterials
    }) => {

    const sumOfAll = Math.round((sumOfWorks + sumOfMaterials) * 100) / 100;

    return (
        <Row className="justify-content-between">
            <div className="col-sm-10 col-md-5 col-lg-5 col-xl-5">
                <DescriptionRaw title={"Смета"} value={estimateName}/>
            </div>
            <div className="col-sm-10 col-md-6 col-lg-6 col-xl-6">
                <Container>
                    <Row>
                        <TabDescriptionColumn title={"Категория:"}
                                              dataOfWorks={"Работы:"}
                                              dataOfMaterials={"Материалы:"}
                        />
                        <TabDescriptionColumn title={"Стоимость"}
                                              dataOfWorks={sumOfWorks}
                                              dataOfMaterials={sumOfMaterials}
                        />
                        <div className="align-self-center">
                            <h4>{sumOfAll}</h4>
                        </div>
                    </Row>
                </Container>
            </div>
        </Row>
    )
}