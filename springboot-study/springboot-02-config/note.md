# 自动配置原理
1. SpringBoot启动的时候加载主配置类，开启了自动配置功能 @EnableAutoConfiguration
2. @EnableAutoConfiguration 作用
   1. 利用EnableAutoConfigurationImportSelector给容器中导入一些组件
   2. 在类路径下,META-INF/spring.factories里面配置的所有EnableAutoConfiguration的值加入到容器中：
   + 每一个这样的 xxxAutoConfiguration类都是容器中的一个**组件**，都**加入到容器中**；用他们来做**自动配置**；

# 总结
1. SpringBoot启动会加载大量的自动配置类
2. 我们看我们需要的功能有没有在SpringBoot默认写好的自动配置类当中；
3. 我们再来看这个自动配置类中到底配置了哪些组件；（只要我们要用的组件存在在其中，我们就不需要再手动配置了）
4. 给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们只需要在配置文件中指定这些属性的值即可；
**xxxxAutoConfigurartion：自动配置类**给容器中添加组件
xxxxProperties:封装配置文件中相关属性；

## other
配置