import { Answer } from "./answer";

export class Question {
    public uid?: number;
    public qid?: number;
    public title?: string
    public desc?: string;
    public answers: Answer[] = [];
    public img_url?:string;
    public approval?:number
    
    constructor( uid:number,qid:number, title:string,desc:string, img_url?:string,approval?:number, answers: Answer[] = []) { 
       this.qid = qid;
       this.uid = uid;
       this.approval = approval;
       this.title = title;
       this.desc = desc;
       this.img_url = img_url;
       this.answers = answers;
    };

    public setQid(qid:number){
        this.qid = qid;
    }

    public getQid():any{
        return this.qid;
    }

    public setTitle(title:string){
        this.title = title;
    }

    public getTitle():any{
        return this.title;
    }

    public setUid(uid:number){
        this.uid = uid;
    }

    public getUid():any{
        return this.qid;
    }

}