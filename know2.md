### Jackson JSON library ���Ѿ�Ĭ�ϰ����� web starter�У�
ʹ��jackson�⣬��model class�Զ����ͳ�==��JSON��

### @RequestParam��value="" defaultValue=""�� ��query�Ĳ����������

###@RestController ����һ�����󣬶�����һ��view����MVC controller����
������󣬱��뱻ת��ΪJSON�����������У�, Spring��HTTP message converter,
Jackson 2 is on the classpath�Զ���ѡ������ת����



####
ʹ�ó־û����ߵ�ʱ��һ�㶼��һ�����������������ݿ⣬
* ��ԭ����Hibernate�н���Session��
* ��JPA�н���EntityManager��
* ��MyBatis�н���SqlSession


#### ����Spring bootĬ���Ѿ�������Hibernate, ��������ֻ����pom.xml����jpa��mysql���ӿ�.

<dependency>  
  <groupId>org.springframework.boot</groupId>  
  <artifactId>spring-boot-starter-data-jpa</artifactId>  
</dependency>  

<dependency>
  <groupId>mysql</groupId>  
  <artifactId>mysql-connector-java</artifactId>  
</dependency>
��ѯmysql�������汾�� https://mvnrepository.com/artifact/mysql/mysql-connector-java

###JPA ��һ�׹淶������һ�ײ�Ʒ ====> ������ DAO ��Ĳ���
Jpa (Java Persistence API) �� Sun �ٷ������ Java �־û��淶��
�ṩһ�֡�����/����ӳ�乤�ߡ������� Java Ӧ���еġ���ϵ���ݡ���
====���ü���Ĵ��뼴��ʵ�ֶ����ݵķ��ʺͲ�����
====�����ṩ�˰�����ɾ�Ĳ�����ڵĳ��ù��ܣ���������չ��

##JPAӵ����Щע��:
@Entity  ������Ϊʵ����
@Table  ����������
@Id  ָ����������ԣ�����ʶ��һ�����е���������
@Column  ָ���־����������ԡ�


## ������ѯ�� 2�ַ���
# 1.Ĭ�Ϸ��� �� SpringBoot JPAĬ��Ԥ��������һЩCRUD�ķ�����
* ��Ҫ �̳�JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {
  @Test
  public void testBaseQuery() throws Exception {
  User user=new User();
  userRepository.findAll();  //Ĭ�Ϸ���
  userRepository.save(user);
  }
}

# 2.���ݲ�ѯ�������Զ����ɽ����� SQL ��
* �Զ��ļ򵥲�ѯ ====> ���ݷ��������Զ����� SQL
(�﷨��findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy�������������XX)
  User findByUserNameOrEmail(String username, String email);
  Long deleteById(Long id);

* ���Ӳ�ѯ����ҳ��ɾѡ������Ȳ�ѯ��
* JPA������ʵ���˷�ҳ���ܣ���ѯ��ʱ�򣬴������Pageable�ȿɡ�
  Pageable pageable = new PageRequest(page, size, sort);
  Page<User> findALL(Pageable pageable);
  Page<User> findByUserName(String userName,Pageable pageable);
  

* ��SQL��ѯ�����ϣ�ʹ��@Queryע�⣬��ɾ�����޸��ϼ���@Modifying
* ��� @Transactional�������֧�֣���ѯ��ʱ������

@Modifying
@Query("update User u set u.userName = ?1 where u.id = ?2")
int modifyByIdAndUserId(String  userName, Long id);

@Transactional
@Modifying
@Query("delete from User where id = ?1")
void deleteByUserId(Long id);

@Transactional(timeout = 10)
@Query("select u from User u where u.emailAddress = ?1")
User findByEmailAddress(String emailAddress)

* ����ѯ�����ַ�ʽ1.���� Hibernate �ļ�����ѯ��ʵ�֣� 2.����һ��������Ľӿ������������ѯ��Ľ����

### ����DB��2�ַ�ʽ
####1.ʹ��JdbcTemplate��  <artifactId>mysql-connector-java
List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
for (Map<String, Object> map : list)

####2.m����Mybatis   <artifactId>mybatis-spring-boot-starter









