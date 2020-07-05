import React from "react";
import {DescriptionRaw} from "./DescrpirtionRaw";
import {ProgressBarComplete} from "./ProgressBarComplete";

type TabDescriptionProps = {
    estimateName: string,
    valueAll: number,
    valueDone: number,
    valuePay: number,
    percent: number
}
export const TabDescription: React.FC<TabDescriptionProps> = (
    {estimateName, valueAll, valueDone, valuePay, percent}
) => {

    return (
        <div className="row justify-content-between">
            <div className="col-sm-12 col-md-5 col-lg-5 col-xl-5">
                <DescriptionRaw title={"Смета"} value={estimateName}/>
            </div>
            <div className="col-sm-12 col-md-6 col-lg-5 col-xl-5">
                <ProgressBarComplete
                    valueAll={valueAll}
                    valueDone={valueDone}
                    valuePay={valuePay}
                    percent={percent}
                />
            </div>
        </div>
    )
}