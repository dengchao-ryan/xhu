<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>YS欢迎您</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
</head>
<body>
<div class="beg-login-box">
    <!-- 头部开始-->
    <div class="top-box">
        <!--logo开始-->
        <div class="logo-window-box">
            <div class="logo-box">
                <a class="site-url" href="##">
                    <img class="site-logo" src="${pageContext.request.contextPath}/image/logo-site.png">
                </a>
            </div>
            <div class="to-mainpage-box">
                <span class="to-mainpage-button">
                    <a href="${pageContext.request.contextPath}/jsp/mainPage.jsp">
                        首页<<
                    </a>
                </span>
            </div>
        </div>
        <!-- 列表-->
        <div class="selection-box">
            <ul>
                <li class="main-level-1">
                    <a class="xhu-info" href="${pageContext.request.contextPath}/jsp/mainPage.jsp" target="_self">学校简介</a>
                </li>
                <li class="main-level-1">
                    <a class="xhu-new-method" href="${pageContext.request.contextPath}/jsp/newStudent.jsp" target="_self">报道流程</a>
                </li>
                <li class="main-level-1">
                    <a class="xhu-login" href="${pageContext.request.contextPath}/jsp/login.jsp" target="_self">新生报道</a>
                </li>
                <li class="main-level-1">
                    <a class="xhu-setting" href="${pageContext.request.contextPath}/jsp/login.jsp" target="_self">信息管理</a>
                </li>
                <li class="main-level-1">
                    <a class="old-market" href="http://localhost:8088/chatroom/" target="_self">YS聊天室</a>
                </li>
                <li class="main-level-1">
                    <a href="${pageContext.request.contextPath}/jsp/adminLoginPage.jsp" title="管理员" class="column-item-link" name="by" id="b8" onclick="show(8)">
                        <span class="column-name">管理员</span>
                    </a>
                </li>
            </ul>
        </div>
        <!-- 头部结束 -->
    </div>
    <!-- 水平线 -->
    <div class="line-level-box">
        <hr noshade="noshade" style="background-color: #88a3ff;height: 2px"/>
    </div>
    <!-- 显示区 -->
    <div class="show-message-box">
        <div class="show-img-box"></div>
        <div class="show-info-box" fra="面板1">
            <h3>西华简介</h3>
            <div class="show-column-box">
                <p class="show-article">
                    西华大学是一所学科门类齐全、多学科协调发展的省属综合性大学，是国家中西部高校基础能力建设工程重点支持高校，教育部易班全国共建示范高校，教育部本科教学工作水平评估优秀高校，
                    四川省首批深化创新创业教育改革示范高校，四川省首批文明校园，四川省绿化先进单位.
                </p>
                <p>
                    学校现有校本部、彭州校区、人南校区三个校区，校园面积3300余亩。校本部坐落于中国历史文化名城成都，毗邻国家高新技术开发区西区，西依望丛帝乡、扬雄故里，岷江水自都江堰而下从
                    校园蜿蜒流过。校园环境大气优雅，植被葱郁，景色宜人，具有得天独厚的人文自然环境，是读书治学的理想园地。学校教务管理、党政办公、图书馆文献信息、后勤服务等均实现网络化，校
                    园网为师生员工的工作、学习和生活营造了良好的数字环境。 图书馆面积5万余平方米，藏书250余万册，电子文献6500GB、210余万种。是全国收藏《中华再造善本》的100所高校之一。

                </p>
                <p>

                    学校办学历史可追溯到建于1960年的四川农业机械学院，是为响应毛泽东主席提出的“农业的根本出路在于机械化”的号召，在当时全国7个大区分别布点所建立的农业机械本科院校之一。1972
                    年，四川农业机械学院更名为成都农业机械学院，1978年，被四川省政府列为省属重点大学，1983年，更名为四川工业学院。1971年成立的温江地区五七师范学校和1982年成立的四川经济管理
                    干部学院是学校发展史上的重要源流。温江地区五七师范学校先后更名为温江地区师范学校（1979年）、温江师范专科学校（1982年）、成都师范专科学校（1985年）和成都师范高等专科学校
                    （1993年），是四川省建立较早的高等师范专科学校。四川经济管理干部学院是独立设置的以培养高中级经济管理人才为目标的高等院校，1999年更名为四川经济管理学院。2003年，四川工业
                    学院和成都师范高等专科学校合并组建西华大学，2008年，四川经济管理学院整体并入。

                </p>
                <p>
                    58年办学薪火相传。学校虽几经更名、合并，但学校始终坚持社会主义办学方向，落实立德树人根本任务，坚持“立足四川，面向西部，辐射全国”的服务定位，秉持“求是、明德、卓越”的校训，
                    树立“育人为本、质量立校、人才强校、特色兴校、依法治校”的办学理念，坚持“改革创新、开放办学、协调推进、特色发展”的办学思路，以成为国家和区域创新体系的重要组成部分，成为四川
                    省创新人才培养、科学技术研究、文化建设、智库咨询重要基地为目标，主动适应国家和四川省经济社会发展需求，以内涵提升为核心，全面提高人才培养质量和办学水平。
                </p>
                <p>

                    学校坚持以本科教育为主，积极发展研究生教育和国际教育，统筹协调、分类指导，形成工、理、管、法、经、艺、文、教等多学科协调发展的格局。现有27个学院，8个学科门类的86个本科专
                    业，18个一级学科硕士学位授权点，7个专业硕士学位类别。现有全日制在校本科学生3.4万人，研究生近2000人。

                </p>
                <p>

                    学校现有4个国家级特色专业，14个省级特色专业，1个国家级专业综合改革试点项目，3个省级专业综合改革试点项目，2个省级应用型人才培养基地，16个四川省“卓越工程师教育培养计划”
                    专业，1个四川省“卓越农林师教育培养计划”专业，2个省级应用型本科示范专业, 1个专业已通过工程教育专业认证，2个专业已完成专家进校现场考查。学校面向全国招生，并招收乒乓球、
                    健美操、跆拳道高水平运动队学生和边防军人子女预科。具有面向全国推荐优秀应届本科毕业生免试攻读硕士学位研究生资格。

                </p>
                <p>
                    近年来，在“挑战杯”全国大学生课外学术科技作品竞赛、中国“互联网+”大学生创新创业大赛、教育部全国大学生网络创新创业大赛、“创青春”创业竞赛、机器人大赛、中国大学生方程式汽车
                    大赛、全国大学生数学建模竞赛、全国大学生电子设计竞赛等国内外重大学科竞赛中，学校获得国家级奖450项，省级奖840项。在大学生体育竞赛中获得国家级团体冠军40余个，个人冠军20余人次。
                    土木建筑与环境学院学生团队设计作品获得2017大学生桥梁设计大赛总决赛唯一的特等奖；汽车与交通学院学生杨文浩获得第44届世界技能大赛“汽车技术”项目的银牌，实现了中国在这个赛项上奖
                    牌零的突破，获得李克强总理的亲切接见；理学院学生获得美国大学生数学建模竞赛国际特等奖提名奖（Finalist）。奥运会金牌获得者陈龙灿执教的学校乒乓球高水平运动队，获第28届世界大学生
                    夏季运动会乒乓球男团冠军，培养的西华学子朱雨玲荣获第21届乒乓球世界杯女单冠军；西华啦啦操获得世界啦啦操锦标赛第三的优异成绩；跆拳道高水平运动队获第二届亚洲大学生跆拳道锦标赛团
                    体季军和两个单项冠军。学生艺术团获世界青少年合唱节民族歌曲金奖，参加央视春晚等多台文艺演出；在教育部、中央网信办举办的全国高校校园好声音比赛中，学校获得两届冠军、一届亚军；在
                    近两届的四川省大学生艺术节中，学校共获各类奖项57项。
                </p>
            </div>
        </div>
    </div>
</div>

</body>
</html>