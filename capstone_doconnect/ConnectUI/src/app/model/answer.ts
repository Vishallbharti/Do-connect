export class Answer {
    constructor(
        public aid?: number,
        public uid?: number,
        public qid?: number,    
        public ans?: string,
        public img_url?:string,
        public approval?:number
     
    ) { }

}