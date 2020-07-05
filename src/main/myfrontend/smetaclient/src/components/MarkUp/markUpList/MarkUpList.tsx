import React, {useEffect} from "react";
import {MyToast} from "../../Generic/MyToast/MyToast";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPercent} from "@fortawesome/free-solid-svg-icons";
import {MarkUpListTable} from "./MarkUpListTable";
import {useDispatch, useSelector} from "react-redux";
import {findAllMarkUps} from "../../../service/actions/markUpActions";
import {IRootState} from "../../../interfaces/IRootState";
import Container from "react-bootstrap/Container";
import Card from "react-bootstrap/Card";

const MarkUpList: React.FC = () => {

    const markUps = useSelector((state: IRootState) => state.markUps.markUps)
    const show = useSelector((state: IRootState) => state.app.show)
    const messageText = useSelector((state: IRootState) => state.app.messageText)
    const messageType = useSelector((state: IRootState) => state.app.messageType)
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(findAllMarkUps())
    }, [dispatch])

    return (
        <Container className="text-center col-sm col-md-5 col-lg-4 col-xl-3">
            <MyToast show={show} message={messageText} type={messageType}/>
            <Card className="border border-dark m-3">
                <Card.Header>
                    <FontAwesomeIcon icon={faPercent}/>&nbsp;Наценки
                </Card.Header>
                <Card.Body>
                    <MarkUpListTable markUps={markUps}/>
                </Card.Body>
            </Card>
        </Container>
    )
}
export default MarkUpList