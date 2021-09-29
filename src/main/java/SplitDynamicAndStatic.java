/**
 * 动静分离
 * 图片，css, js 文件
 *
 * 1、架构
 * 客户端 -> 反向代理服务器（nginx） ---> tomcat 服务器, jps, servlet
 *                           |
 *                           |
 *                           |------> 静态资源, css, html
 *
 * 2、独立部署
 *      独立把静态文件放到单独部署的服务器，访问静态文件时候，通过nginx 转发
 *
 * 3、缓存
 *      通过 location 进行转发请求，通过 expire 设置浏览器的缓存时间，即配置放在浏览器
 *
 * 4、配置
 *      location /www/ {
 *          root: index.html;
 *      }
 *
 *      location ~ *.js {
 *          /js 路径/
 *      }
 *
 */
public class SplitDynamicAndStatic {
}
