import {Dispatch} from "react";
import {showAppMessage} from "./appActions";
import {MyToastMessageText} from "../../utils/MyToastMessageText";
import {MyToastMessageType} from "../../utils/MyToastMessageType";
import {IEstimateDetail} from "../../interfaces/IEstimateDetail";
import {
    DELETE_ESTIMATE_DETAIL,
    FIND_ALL_ESTIMATE_DETAILS,
    TOGGLE_ESTIMATE_DETAIL
} from "../actionTypes/estimateDetailActionTypes";
import {INewEstimateDetail} from "../../interfaces/INewEstimateDetail";


const findAllEstimateDetailsSuccess = (estimateDetails: IEstimateDetail[]) => {
    return {
        type: FIND_ALL_ESTIMATE_DETAILS,
        payload: estimateDetails
    }
}
const deleteEstimateDetailSuccess = (estimateDetailId: number) => {
    return {
        type: DELETE_ESTIMATE_DETAIL,
        payload: estimateDetailId
    }
}
const toggleEstimateDetailCompleteSuccess = (estimateDetailId: number) => {
    return {
        type: TOGGLE_ESTIMATE_DETAIL,
        payload: estimateDetailId
    }
}

export function findAllEstimateDetails(estimateId: number) {
    return async (dispatch: Dispatch<any>) => {
        try {
            await fetch("/estimateDetails/estimateId/" + estimateId)
                .then(response => response.json())
                .then((estimateDetails: IEstimateDetail[]) => {
                    dispatch(findAllEstimateDetailsSuccess(estimateDetails))
                })
        } catch (e) {
            dispatch(showAppMessage(MyToastMessageText.ErrorRequestServer, MyToastMessageType.Error))
        }
    }
}

export function deleteEstimateDetail(estimateDetailId: number) {
    return async (dispatch: Dispatch<any>) => {
        try {
            await fetch("/estimateDetails/" + estimateDetailId, {method: 'DELETE'})
                .then(() => {
                    dispatch(deleteEstimateDetailSuccess(estimateDetailId))
                    dispatch(showAppMessage(MyToastMessageText.SuccessDelete, MyToastMessageType.Success))
                })
        } catch (e) {
            dispatch(showAppMessage(MyToastMessageText.SomeError, MyToastMessageType.Error))
        }
    }
}

export function updateEstimateDetail(estimateDetail: IEstimateDetail) {
    return async (dispatch: Dispatch<any>) => {
        try {
            const headers = new Headers();
            headers.append('Content-Type', 'application/json');
            await fetch("/estimateDetails", {
                method: 'PUT',
                body: JSON.stringify(estimateDetail),
                headers
            })
                .then(response => response.json())
                .then(estimateDetail => {
                    if (estimateDetail) {
                        dispatch(findAllEstimateDetails(estimateDetail.estimateId))
                    }
                })
        } catch (e) {
            dispatch(showAppMessage(MyToastMessageText.SomeError, MyToastMessageType.Error))
        }
    }
}

export function saveNewEstimateDetail(estimateDetail: INewEstimateDetail) {
    return async (dispatch: Dispatch<any>) => {
        try {
            const headers = new Headers();
            headers.append('Content-Type', 'application/json');
            await fetch("/estimateDetails", {
                method: 'POST',
                body: JSON.stringify(estimateDetail),
                headers
            })
                .then(response => response.json())
                .then(estimateDetail => {
                    if (estimateDetail) {
                        dispatch(showAppMessage(MyToastMessageText.SuccessSave, MyToastMessageType.Success))
                    }
                })
        } catch (e) {
            dispatch(showAppMessage(MyToastMessageText.SomeError, MyToastMessageType.Error))
        }
    }
}