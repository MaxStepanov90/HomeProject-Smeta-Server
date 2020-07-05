import React from "react";
import {TabDescriptionColumn} from "../../../Generic/TabDescriptionColumn";
import {DescriptionRaw} from "../../../Generic/DescrpirtionRaw";
import {Col, Container, Row} from "react-bootstrap";

type TabGeneralDescriptionProps = {
    estimateName: string,
    sumOfWorks: number,
    sumOfMaterials: number,
    sumOfMarkUpFromWorks: number,
    sumOfMarkUpFromMaterials: number,
    sumOfWorksWithMarkUp: number,
    sumOfMaterialsWithMarkUp: number,
}
export const GeneralTabDescription: React.FC<TabGeneralDescriptionProps> = (
    {
        estimateName, sumOfWorks, sumOfMaterials, sumOfWorksWithMarkUp,
        sumOfMaterialsWithMarkUp,
    }) => {

    const dataOfAll = Math.round((sumOfWorks + sumOfMaterials) * 100) / 100;
    const sumOfAll = Math.round((sumOfWorksWithMarkUp + sumOfMaterialsWithMarkUp) * 100) / 100;

    return (
        <Row className="justify-content-between">
            <div className="col-sm-12 col-md-5 col-lg-5 col-xl-5">
                <DescriptionRaw title={"Смета"} value={estimateName}/>
            </div>
            <Col className="col-sm-12 col-md-6 col-lg-6 col-xl-6">
                <Container>
                    <Row>
                        <TabDescriptionColumn title={"Категория:"}
                                              dataOfWorks={"Работы:"}
                                              dataOfMaterials={"Материалы:"}
                                              dataOfAll={"Итого:"}
                        />
                        <TabDescriptionColumn title={"Стоимость"}
                                              dataOfWorks={sumOfWorks}
                                              dataOfMaterials={sumOfMaterials}
                                              dataOfAll={dataOfAll}
                        />
                        <Col className="align-self-center">
                            <h4>{sumOfAll}</h4>
                        </Col>
                    </Row>
                </Container>
            </Col>
        </Row>
    )
}