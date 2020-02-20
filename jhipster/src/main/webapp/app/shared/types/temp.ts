/*
    This file is supposed to be erased soon, since it contains data format which
    should come from Jhipster. If you need to define an actual and permanent data 
    format, use another file.
*/

export interface IQuestion {
    answerType: string,
    title: string,
    id: string,
    restrictions: Array<IRestriction>
}

export interface IRestriction {
    label: string,
    id: string
}