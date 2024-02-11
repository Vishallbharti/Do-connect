import { QuestionBean } from "./questionBean";

export class AnswerBean {
    public ans_id?: number;
    public description?: string;
    public img_url?: string;
    public user_id?: number;
    public approval?: number;
    public question: QuestionBean;
    constructor(question: QuestionBean) {
          this.question = question;
    }
}