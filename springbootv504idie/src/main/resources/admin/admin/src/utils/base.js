const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootv504idie/",
            name: "springbootv504idie",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootv504idie/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于软件研发过程中的缺陷管理系统的设计与实现"
        } 
    }
}
export default base
