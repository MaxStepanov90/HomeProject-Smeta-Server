import React, {FormEvent, useState} from 'react';

import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faFolderPlus, faList, faSave} from '@fortawesome/free-solid-svg-icons';
import {MyToast} from "../../Generic/MyToast/MyToast";
import {useDispatch, useSelector} from "react-redux";
import {saveNewProject} from "../../../service/actions/projectActions";
import {IRootState} from "../../../interfaces/IRootState";
import Form from 'react-bootstrap/Form';
import Container from "react-bootstrap/Container";
import Card from 'react-bootstrap/Card';
import Button from "react-bootstrap/Button";
import 'react-datepicker/dist/react-datepicker.css';

interface RouterProps {
    id: string;
}

interface ProjectFormProps extends RouterProps {
    history: any
}

const ProjectForm: React.FC<ProjectFormProps> = ({history}) => {

    const dispatch = useDispatch()
    const show = useSelector((state: IRootState) => state.app.show)
    const messageText = useSelector((state: IRootState) => state.app.messageText)
    const messageType = useSelector((state: IRootState) => state.app.messageType)
    const [projectContract,setProjectContract] = useState('')
    const [projectName,setProjectName] = useState('')
    const [projectAddress,setProjectAddress] = useState('')
    const [projectCreationDate,setProjectCreationDate] = useState('')
    const [projectDescription,setProjectDescription] = useState('')
    const [projectOwner,setProjectOwner] = useState('')

    const submitProject = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const newProject = {
            contract: projectContract,
            name: projectName,
            address: projectAddress,
            creationDate: projectCreationDate,
            description: projectDescription,
            owner: projectOwner
        };
        console.log(newProject)
        dispatch(saveNewProject(newProject));
        setTimeout(() => projectList(), 1600);
    }

    const projectList = (): void => {
        return history.push("/projects")
    };

    const projectContractInputField =
        <Form.Group className="col-sm-12 col-md-4 col-lg-4 col-xl-4" controlId="formGridProjectContract">
            <Form.Label>Договор</Form.Label>
            <Form.Control required autoComplete="off"
                          type="text" name="projectContract"
                          value={projectContract} onChange={e => setProjectContract(e.target.value)}
            />
        </Form.Group>
    const projectNameInputField =
        <Form.Group className="col-sm-12 col-md-6 col-lg-6 col-xl-6" controlId="formGridProjectName">
            <Form.Label>Название проекта</Form.Label>
            <Form.Control required autoComplete="off"
                          type="text" name="projectName"
                          value={projectName} onChange={e => setProjectName(e.target.value)}
            />
        </Form.Group>
    const projectAddressInputField =
        <Form.Group className="col-sm-12 col-md-6 col-lg-6 col-xl-6" controlId="formGridProjectAddress">
            <Form.Label>Адрес объекта</Form.Label>
            <Form.Control required autoComplete="off"
                          type="text" name="projectAddress"
                          value={projectAddress} onChange={e => setProjectAddress(e.target.value)}
            />
        </Form.Group>
    const projectCreationDateInputField =
        <Form.Group className="col-sm-12 col-md-4 col-lg-4 col-xl-4" controlId="formGridProjectCreationDate">
            <Form.Label>Дата создания договора</Form.Label>
            <Form.Control
                required autoComplete="off"
                type="date" name="projectCreationDate"
                value={projectCreationDate} onChange={e => setProjectCreationDate(e.target.value)}
            >
            </Form.Control>

        </Form.Group>
    const projectOwnerInputField =
        <Form.Group className="col-sm-12 col-md-4 col-lg-4 col-xl-4" controlId="formGridProjectOwner">
            <Form.Label>Заказчик</Form.Label>
            <Form.Control required autoComplete="off"
                          type="test" name="projectOwner"
                          value={projectOwner} onChange={e => setProjectOwner(e.target.value)}
            />
        </Form.Group>
    const projectDescriptionInputField =
        <Form.Group className="col" controlId="formGridProjectDescription">
            <Form.Label>Описание</Form.Label>
            <Form.Control required autoComplete="off"
                          as="textarea"
                          rows={3}
                          type="test" name="projectDescription"
                          value={projectDescription} onChange={e => setProjectDescription(e.target.value)}
            />
        </Form.Group>

    return (
        <Container>
            <MyToast show={show} message={messageText} type={messageType}/>
            <Card className="border border-dark m-3">
                <Card.Header>
                    <FontAwesomeIcon icon={faFolderPlus}/>&nbsp;Новый проект
                </Card.Header>
                <Form onSubmit={submitProject} id="projectFormId">
                    <Card.Body>
                        <Form.Row>
                            {projectContractInputField}
                            {projectCreationDateInputField}
                            {projectOwnerInputField}
                        </Form.Row>

                        <Form.Row>
                            {projectNameInputField}
                            {projectAddressInputField}
                        </Form.Row>
                        <Form.Row>
                            {projectDescriptionInputField}
                        </Form.Row>
                    </Card.Body>
                    <Card.Footer style={{"textAlign": "center"}}>
                        <Button size="sm" variant="success" type="submit">
                            <FontAwesomeIcon icon={faSave}/>&nbsp;Создать
                        </Button>{' '}
                        <Button size="sm" variant="info" type="button" onClick={() => projectList()}>
                            <FontAwesomeIcon icon={faList}/>&nbsp;Проекты
                        </Button>
                    </Card.Footer>
                </Form>
            </Card>
        </Container>
    );
}
export default ProjectForm