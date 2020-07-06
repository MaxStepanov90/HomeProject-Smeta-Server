import React, {FormEvent, useEffect, useState} from "react";
import {MyToast} from "../../Generic/MyToast/MyToast";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPercent, faSave, faUndo} from "@fortawesome/free-solid-svg-icons";
import Row from "react-bootstrap/Row";
import {IMarkUp} from "../../../interfaces/IMarkUp";
import {findMarkUpById, updateMarkUp} from "../../../service/actions/markUpActions";
import {useDispatch, useSelector} from "react-redux";
import {IRootState} from "../../../interfaces/IRootState";
import Container from "react-bootstrap/Container";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Button from "react-bootstrap/Button";

interface RouterProps {
    id: string;
}

interface MarkUpFormProps extends RouterProps {
    match: any,
    history: any
}

const MarkUpForm: React.FC<MarkUpFormProps> = ({history, match}) => {

    const dispatch = useDispatch()

    const {show, messageText, messageType, markUp} = useSelector(
        (state: IRootState) => ({
            show: state.app.show,
            messageText: state.app.messageText,
            messageType: state.app.messageType,
            markUp: state.markUps.markUp,
        }))

    const [markUpPercent, setMarkUpPercent] = useState(markUp.markUpPercent)

    useEffect(() => {
        const markUpId = parseInt(match.params.id)
        if (markUpId) {
            dispatch(findMarkUpById(markUpId));
        }
    }, [dispatch])

    const update = (event: FormEvent<HTMLFormElement>): void => {
        event.preventDefault();
        const newMarkUp: IMarkUp = {
            id: markUp.id,
            markUpName: markUp.markUpName,
            markUpPercent: markUp.markUpPercent,
        }
        dispatch(updateMarkUp(newMarkUp));
        setTimeout(() => markUpList(), 1600);
    };

    const markUpList = (): void => {
        return history.push("/markUps")
    };

    return (
        <Container className="text-center col-sm col-md-5 col-lg-4 col-xl-3">
            <MyToast show={show} message={messageText} type={messageType}/>
            <Card className="border border-dark m-3">
                <Card.Header>
                    <FontAwesomeIcon icon={faPercent}/>&nbsp;Наценка
                </Card.Header>
                <Form onSubmit={update} id="markUpFormId">
                    <Card.Body>
                        <Form.Row className="justify-content-center">
                            <Form.Group as={Row} controlId="formPlaintextMarkUpName">
                                <Form.Label column sm="7">
                                    {markUp.markUpName}
                                </Form.Label>
                                <Col sm="4">
                                    <Form.Control required autoComplete="off"
                                                  type="text" name="percent"
                                                  value={markUp.markUpPercent}
                                                  onChange={event => setMarkUpPercent(parseInt(event.target.value))}/>
                                </Col>
                            </Form.Group>
                        </Form.Row>
                    </Card.Body>
                    <Card.Footer>
                        <div className="row justify-content-between">
                            <div className="col">
                                <Button size="sm" variant="primary"
                                         onClick={() => markUpList()}>
                                    <FontAwesomeIcon icon={faUndo}/>&nbsp;Вернуться
                                </Button>
                            </div>
                            <div className="col">
                                <Button size="sm" variant="success" type="submit">
                                    <FontAwesomeIcon icon={faSave}/>&nbsp;Сохранить
                                </Button>{' '}
                            </div>
                        </div>
                    </Card.Footer>
                </Form>
            </Card>
        </Container>
    )
}

export default MarkUpForm