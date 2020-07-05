import React, {Fragment} from "react";
import {IProject} from "../../../interfaces/IProject";
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTrash} from "@fortawesome/free-solid-svg-icons";
import Button from "react-bootstrap/Button";
import {deleteProject} from "../../../service/actions/projectActions";
import {useDispatch} from "react-redux";

type ProjectItemProps = {
    project: IProject
}
export const ProjectItem: React.FC<ProjectItemProps> = ({project}) => {

    const dispatch = useDispatch()

    return (
        <Fragment>
            <tr>
                <td>
                    <Link to={"projectInfo/" + project.id} className="text-dark">
                        {project.name}
                    </Link>
                </td>
                <td>{project.address}</td>
                <td>{project.owner}</td>
                <td className="text-center">
                    <Button variant="outline-danger"
                            onClick={() => dispatch(deleteProject(project.id))}>
                        <FontAwesomeIcon icon={faTrash}/>
                    </Button>
                </td>
            </tr>
        </Fragment>
    )
}