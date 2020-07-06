import React, {useState} from "react";
import {ProjectInfoProgressBar} from "./ProjectInfoProgressBar";
import {Container} from "react-bootstrap";
import {DescriptionRaw} from "../../Generic/DescrpirtionRaw";
import {IEstimate} from "../../../interfaces/IEstimate.";
import {useSelector} from "react-redux";
import {IRootState} from "../../../interfaces/IRootState";
import {faInfo, faInfoCircle, faStepForward} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

type ProjectInfoDescriptionProps = {
    estimates: IEstimate[],
}
export const ProjectInfoDescription: React.FC<ProjectInfoDescriptionProps> = ({estimates}) => {

    const project = useSelector((state: IRootState) => state.projects.project)
    const [visible, setVisible] = useState(false)
    const buttonText = visible ? "скрыть детали" : "подробнее...";

    const sumAllEstimateCost = (estimates: IEstimate[]): number => {
        let sum = 0;
        for (let i = 0; i < estimates.length; i++) {
            sum += estimates[i].cost;
        }
        return sum
    };

    return (
        <div className="row justify-content-between">
            <div className="col-sm col-md-5 col-lg-5 col-xl-5">
                <Container>
                    <div className="row">
                        <div className="col"
                             onClick={() => setVisible(!visible)}>
                            <h5>{project.name}</h5>
                        </div>
                    </div>
                    {visible ?
                        <div>
                            <DescriptionRaw title={"Адрес"} value={project.address}/>
                            <DescriptionRaw title={"Договор"} value={project.contract}/>
                            <DescriptionRaw title={"Заказчик"} value={project.owner}/>
                            <DescriptionRaw title={"Описание"} value={project.description}/>
                        </div>
                        : null}
                </Container>
            </div>
            <div className="col-sm col-md-7 col-lg-7 col-xl-7">
                {visible ?
                    <Container>
                        <DescriptionRaw title={"Всего смет"} value={estimates.length}/>
                        <DescriptionRaw title={"Общая cумма"} value={sumAllEstimateCost(estimates)}/>
                        {estimates.map((estimate: IEstimate) => (
                            <ProjectInfoProgressBar
                                key={estimate.id}
                                estimate={estimate}/>))}
                    </Container>
                    : null}
            </div>
        </div>
    )
}