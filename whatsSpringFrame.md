### Spring
### �� XML ���� bean�� ������"ע��"����bean
* bean�Ƕ���,app��һ����bean������bean��SpringIoc��������
Ioc���Զ����@bean�����ʵ������
Iocά����bean����ע���bean����ء�

* ����ʽ�� ע�� + װ�䣨��������Э����ϵ��
* 1.�Զ�����
ʹ�����ע��ע�⡾@Component,@Controller,@Repository��������Spring����һ��bean����Ҫ�������ҡ�
ʹ��@AutoWired����resource�� װ��bean��
 ===��
���ɨ�迪��֮��ȥѰ�Ҵ���@Component���࣬��Ϊ�䴴��bean��

* 2.��JavaConfig  @Configuration����Spring,��Iocȥ��ô����bean��
* 3.XML���ã���ǩ����spring��ô��ȡ���bean,���ֶ����ù�ϵ��
  <xmlns=��ʾĬ�������ռ䡣
  <bean��id����һ���Ǳ�ʶ���������id���б�����,classָ������com.xx.AClass��
  * ��̬���� ʵ����bean
  <bean factory-method="newInstance"
  <constructor-arg name="prodName">ʹ�þ�̬����ʵ����Bean����ָ�����Ρ�
  
  * ʵ��������
    <bean > ��ָ��factory-method���и�id�����ˡ�
    <constructor-arg index="0" value="Hello" ></constructor-arg>

  * ������scope��
    <bean scope="singleton" ����
    <bean scope="propotype" ÿ�ε��ö����� ȫ�µ�ʵ�� 
  * scope����request ÿ��http�����ʱ�򴴽�һ����ʵ����Session, Global session
  �������Զ��塣
  * 
* ## ��ע�⣬��Spring�Զ�ɨ��bean�������á�
* ## @configuration ָ����ǰ����Spring�����֮ࣨǰ����<bean>����ӣ�
*@Bean�������ķ���ֵ����ӵ������У������д������idĬ���Ƿ���������



����ע��
1������
@Component ==>������һ��Bean,����Ĭ���Ǹ����Сдa������һ��������Singleton����
public class A {
  B b;
  A(@Autowired B b0) { this.b = b0; }
}
2��װ��ע�룬����д�� set�����ϣ����캯���У�������ֱ��д���ֶ��ϡ�
@Autowired

�Զ���bean��
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // @Scope("prototype")
public class MailSession {
...
}
�����ظ�bean���屨����Ҫ��bean�ӱ�����@Bean("name")ָ����������Ҳ������@Bean+@Qualifier("name")ָ����������


