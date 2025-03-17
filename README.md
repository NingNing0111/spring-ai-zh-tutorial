&emsp;语雀地址：[https://www.yuque.com/pgthinker/spring-ai](https://www.yuque.com/pgthinker/spring-ai)

- Spring AI - Chat API
  - [快速入门](doc/2.1%20快速入门.md)
  - [流式对话](doc/2.2.%20流式对话.md)
  - [上下文对话](doc/2.3.%20上下文对话.md)
  - [人设设置](doc/2.4.%20人设设置.md)
  - [Prompts 模板语法](doc/2.5.%20Prompts模板语法.md)
  - [基于数据库的多 Key 轮询](doc/2.6.%20基于数据库的多Key轮询.md)
  - [基于 Vue3 实现流式对话](https://github.com/NingNing0111/spring-ai-zh-tutorial/tree/master/spring-ai-v1-stream-chat-demo)
    - 前后端分离，core 是 Vue 源码，static 是 build 出来的静态资源内容
    - 使用最新的 Spring AI 版本：1.0 实现
    - 运行该模块后可以通过：`http://localhost:8898/index.html` 直接访问网站
  - [Function Call 函数调用](doc/2.8.Function%20Call函数调用.md)
- Spring AI - Image API

  - [快速入门+源码介绍](doc/3.1.%20快速入门.md)
  - [AI 自查实现对话和绘画](doc/3.2.%20AI自查判断聊天还是绘图.md)

- Spring AI - Embedding API

  - [Embedding API 快速入门](doc/4.1.%20快速入门.md)
  - [向量数据库概述](doc/4.2.%20向量数据库概述.md)
  - [Embedding API 结合向量数据库](doc/4.3.%20嵌入API结合向量数据库.md)
  - [RAG 实战](doc/4.4.%20RAG实战.md)
  - [权限隔离的 RAG Demo](https://github.com/NingNing0111/permission_rag_demo)
    - 基于部门划分实现权限隔离。RAG 检索到数据仅限于当前用户所在部门的数据。
    - 可扩展：指定某个知识库进行对话。

- Spring AI - Transcription API

- 实战练习项目
  - [know-hub-ai](https://github.com/NingNing0111/know-hub-ai)：Spring AI and PGVector 基于个人知识库的 AI 问答系统。

# Spring AI 教程

&emsp;Spring AI 是 Spring 生态中应用于人工智能领域的应用框架，它的目标是将 Spring 生态系统的设计原则（如可移植性、模块化设计）应用于 AI 领域，并在 AI 领域中推广使用 POJO（Plain Old Java Objects）作为应用的构建模块。

&emsp;Spring AI 能做什么？

- 支持目前主流大语言模型平台，例如 OpenAI、Microsoft、Amazon、Google 和 Huggingface；
- 支持阻塞与流式的文本对话；
- 支持图像生成(当前仅限 OpenAI 的 dall-e-\*模型和 SD)；
- 支持嵌入模型；
- 支持 LLM 生成的内容转为 POJO；
- 支持主流的向量数据库或平台：Azure Vector Search, Chroma, Milvus, Neo4j, PostgreSQL/PGVector, PineCone, Qdrant, Redis 和 Weaviate
- 支持函数调用
- 支持自动装配和启动器（与 Spring Boot 完美集成）；
- 提供用于数据处理工程的 ETL 框架；

&emsp; 相关资料

- GitHub 仓库：[https://github.com/spring-projects/spring-ai](https://github.com/spring-projects/spring-ai)
- 官方文档：[https://spring.io/projects/spring-ai](https://spring.io/projects/spring-ai)

&emsp; 本栏目侧重于讲述：

- 基于 OpenAI 接口实现的对话调用，包括：阻塞式对话和流式对话；
- 实现上下文检索，让 AI 赋予记忆力；
- 基于提示词工程，让 AI 赋予专业能力；
- 基于 OpenAI 接口实现的绘图调用；
- 基于 AI 自查功能，通过文本对话让 AI 自行判断是对话还是绘图；
- 基于 OpenAI 接口实现文本向量化处理；
- 基于文本向量化处理和向量数据库实现 RAG（增强式检索）技术；
- 基于 OpenAI 接口实现音频转录功能，赋予 AI 语音对话能力；
- 基于数据库存储实现多 Key 轮询，突破 API 请求限制；
- 使用 OneAPI 项目，统一世界主流大语言模型的接口；

&emsp;**本教程使用的大语言模型接口均以 OpenAI 为例**。

&emsp;版本说明：

- JDK >= 17
- Spring 6.x;Spring Boot 3.x
- Spring AI 0.8.1-SNAPSHOT + Spring AI 1.0.0
