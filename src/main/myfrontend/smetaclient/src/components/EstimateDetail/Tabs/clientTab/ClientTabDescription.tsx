import React from "react";
import {DescriptionRaw} from "../../../Generic/DescrpirtionRaw";
import {TabDescriptionColumn} from "../../../Generic/TabDescriptionColumn";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Container from "react-bootstrap/Container";

type TabClientDescriptionProps = {
    estimateName: string,
    sumOfWorksWithMarkUp: number,
    sumOfMaterialsWithMarkUp: number
}

export const ClientTabDescription: React.FC<TabClientDescriptionProps> = (
    {estimateName, sumOfWorksWithMarkUp, sumOfMaterialsWithMarkUp}
) => {

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
                                              dataOfWorks={sumOfWorksWithMarkUp}
                                              dataOfMaterials={sumOfMaterialsWithMarkUp}
                        />
                        <div className="align-self-center">
                            <h4>{sumOfWorksWithMarkUp + sumOfMaterialsWithMarkUp}</h4>
                        </div>
                    </Row>
                </Container>
            </div>
        </Row>
    )
}
