Spring AI是Spring生态中应用于人工智能领域的应用框架，它的目标是将Spring 生态系统的设计原则（如可移植性、模块化设计）应用于AI领域，并在AI领域中推广使用POJO（Plain Old Java Objects）作为应用的构建模块。

Spring AI能做什么？

- 支持目前主流大语言模型平台，例如 OpenAI、Microsoft、Amazon、Google 和 Huggingface；
- 支持阻塞与流式的文本对话；
- 支持图像生成(当前仅限OpenAI的dall-e-*模型和SD)；
- 支持嵌入模型；
- 支持LLM生成的内容转为POJO；
- 支持主流的向量数据库或平台：Azure Vector Search, Chroma, Milvus, Neo4j, PostgreSQL/PGVector, PineCone, Qdrant, Redis 和 Weaviate
- 支持函数调用
- 支持自动装配和启动器（与Spring Boot完美集成）；
- 提供用于数据处理工程的ETL框架；

相关资料

- GitHub仓库：[https://github.com/spring-projects/spring-ai](https://github.com/spring-projects/spring-ai)
- 官方文档：[https://spring.io/projects/spring-ai](https://spring.io/projects/spring-ai)

本栏目侧重于讲述：

- 基于OpenAI接口实现的对话调用，包括：阻塞式对话和流式对话；
- 实现上下文检索，让AI赋予记忆力；
- 基于提示词工程，让AI赋予专业能力；
- 基于OpenAI接口实现的绘图调用；
- 基于AI自查功能，通过文本对话让AI自行判断是对话还是绘图；
- 基于OpenAI接口实现文本向量化处理；
- 基于文本向量化处理和向量数据库实现RAG（增强式检索）技术；
- 基于OpenAI接口实现音频转录功能，赋予AI语音对话能力；
- 基于数据库存储实现多Key轮询，突破API请求限制；
- 使用OneAPI项目，统一世界主流大语言模型的接口；

**本教程使用的大语言模型接口均以OpenAI为例**。

版本说明：

- JDK >= 17
- Spring 6.x;Spring Boot 3.x
- Spring AI 0.8.1-SNAPSHOT

依赖配置：
父级`pom.xml`中加入：
```xml
<!-- 仓库定义 -->
<repositories>
    <repository>
      <id>spring-milestones</id>
      <name>Spring Milestones</name>
      <url>https://repo.spring.io/milestone</url>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
    </repository>
    <repository>
      <id>spring-snapshots</id>
      <name>Spring Snapshots</name>
      <url>https://repo.spring.io/snapshot</url>
      <releases>
        <enabled>false</enabled>
      </releases>
    </repository>
  </repositories>
<!-- 依赖管理配置 -->
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-bom</artifactId>
            <version>0.8.1-SNAPSHOT</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
完整信息：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.3</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>org.ningning0111</groupId>
    <artifactId>spring-ai-demo</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>
  
    <modules>
        <module>spring-ai-chat-demo</module>
    </modules>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <spring-ai.version>0.8.1-SNAPSHOT</spring-ai.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.ai</groupId>
                <artifactId>spring-ai-bom</artifactId>
                <version>${spring-ai.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
        <repository>
            <id>spring-snapshots</id>
            <name>Spring Snapshots</name>
            <url>https://repo.spring.io/snapshot</url>
            <releases>
                <enabled>false</enabled>
            </releases>
        </repository>
    </repositories>

</project>
```
