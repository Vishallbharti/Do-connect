import { AnswerBean } from "./answerBean";

export class QuestionBean {
    public que_id?: number;
    public topic?: string;
    public description?: string;
    public img_url?: string;
    public user_id?: number;
    public approval?: number;
    public answers?:AnswerBean[] = [];
    constructor(){
        
    }
}