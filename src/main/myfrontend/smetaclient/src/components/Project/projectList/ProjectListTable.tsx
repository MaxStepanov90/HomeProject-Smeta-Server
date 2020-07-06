import React from "react";
import Table from "react-bootstrap/Table";
import {IProject} from "../../../interfaces/IProject";
import './ProjectStyle.css';
import {ProjectItem} from "./ProjectItem";

type ProjectListTableProps = {
    projects: IProject[],
}

export const ProjectListTable: React.FC<ProjectListTableProps> = ({projects}) => {

    return (
        <Table responsive bordered>
            <thead>
            <tr>
                <th>Название</th>
                <th>Адрес</th>
                <th>Заказчик</th>
            </tr>
            </thead>
            <tbody>
            {projects.length === 0 ?
                <tr>
                    <td align="left" colSpan={12}>Нет доступных проектов.</td>
                </tr> :
                projects.map((project: IProject) => (
                    <ProjectItem key={project.id}
                                 project={project}/>
                ))
            }
            </tbody>
        </Table>
    )
}
