package common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:common.annotation
 * DateTime: 2017/12/15  16:52
 * Description:文档注释
 */


/**
 * 作用范围
 * 1.TYPE               作用在class,interface,enum,annotation
 * 2.FILED              作用在属性上
 * 3.METHOD             作用在方法上
 * 4.PARAMETER          作用在参数上
 * 5.CONSTRUCTOR        作用在构造函数上
 * 6.LOCAL_VARIABLE     作用在局部变量
 * 7.ANNOTATION_TYPE    作用在注解
 * 8.PACKAGE            作用在包
 * *** 如果Annotation中没有Target注解，则默认可以作用在以上任何地方 ***
 */
//@Target(ElementType.METHOD)

/**
 * 保留---> 此种注解可以保留到的阶段
 * 1.RetentionPolicy.SOURCE     源代码级别保留，编译时会被忽略
 * 2.RetentionPolicy.CLASS      编译时会保留，在class文件中会存在，但在JVM中将会忽略
 * 3.RetentionPolicy.RUNTIME    JVM将会保留，能在运行时被JVM或其他使用反射机制的代码读取和使用
 * *** 一般默认为 RetentionPolicy.RUNTIME，程序运行时就会发现这个注解 ***
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * 注解表明 Javadoc工具将会记录
 * *** 默认情况下，javadoc是不包括注解的，但如果生命注解时指定了 @Documented，则它会被javadoc之类的工具处理，记载在生成的文档中
 */
@Documented


/**
 * idea生成javadoc  tools -> Generate JavaDoc
 * *** 参数 ***
 * 1.Output Directory               生成文档存储路径
 * 2.Locale                         文档语言   zh_CN
 * 3.Other command line arguments
 *      -encoding UTF-8 -charset UTF-8 -windowtitle "文档HTML页面标签的标题" -link http://docs.Oracle.com/javase/7/docs/api
 */
public @interface UseDocumented {
    String Document();
}
