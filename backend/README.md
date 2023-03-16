## 后端部分

### 开发规范：

#### 文件树
```
SmartWarehouse
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── seobf
│   │   │           └── SmartWarehouse
│   │   │               ├── SmartWarehouseApplication.java (主应用程序类)
│   │   │               ├── controller (控制器层)
│   │   │               │   └── UserController.java
│   │   │               ├── service (服务层)
│   │   │               │   ├── UserService.java
│   │   │               │   └── impl
│   │   │               │       └── UserServiceImpl.java
│   │   │               ├── repository (数据访问层)
│   │   │               │   └── UserRepository.java
│   │   │               ├── pojo (实体类)
│   │   │               │   └── User.java
│   │   │               └── config (配置类)
│   │   │                   └── DataSourceConfig.java
│   │   └── resources (资源文件)
│   │       ├── application.properties (或application.yml，主配置文件)
│   │       ├── static (静态资源，如CSS、JS、图像等)
│   │       └── templates (Thymeleaf模板等)
│   └── test (单元测试和集成测试)
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── myapp
│       │               ├── MyappApplicationTests.java
│       │               ├── controller
│       │               │   └── UserControllerTest.java
│       │               └── service
│       │                   └── UserServiceTest.java
│       └── resources
│           └── application-test.properties (或application-test.yml，用于测试的配置文件)
├── .gitignore (用于指定在Git版本控制中忽略的文件和目录)
├── pom.xml (Maven项目配置文件)
├── build.gradle (Gradle项目配置文件，如果使用Gradle)
└── README.md (项目说明文档)
```
