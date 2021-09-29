/**
 * nginx 配置高可用的集群
 *
 * 架构
 * request -------> nginx ----> Tomcat1
 *                    |
 *                    |
 *                    --------> Tomcat2
 *                    |
 *                    |
 *                    --------> Tomcat3
 *
 * Question：如果 nginx crash 了，怎么能够让请求仍然正常呢?
 *
 *
 * request
 *    |
 *    |
 *    .------>  (虚拟ip)---->  nginx(master) -----> Tomcat1                            |
 *                  |              |
 *                  |              .------------> Tomcat2
 *                  |-> nginx(slave)
 *                  |
 *                  |
 *                keepAlive 检测是否还是活着的
 */
public class HIghAvailability {
}
