package com.zwt.demo;


import com.zwt.demo.circularreference.TestA;
import com.zwt.demo.circularreference.TestB;
import com.zwt.demo.mapper.ScoreMapper;
import com.zwt.demo.mapper.StudentMapper;
import com.zwt.demo.model.StudentModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void cacheTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        System.out.println(studentMapper.selectByPrimaryKey(1));
        System.out.println(studentMapper.selectByPrimaryKey(1));
        System.out.println(studentMapper.selectByPrimaryKey(1));
    }
    @Test
    public void cacheTest1() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.selectByPrimaryKey(1);
        StudentModel studentModel = new StudentModel();
        studentModel.setStuName("赵六");
        studentModel.setStuNo("4");
        studentModel.setStuClass("1");
        studentModel.setStuSex("1");
        studentMapper.insert(studentModel);
        studentMapper.selectByPrimaryKey(1);
    }

    @Test
    public void cacheTest3() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        StudentMapper studentMapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        System.out.println("studentMapper1->"+studentMapper1.selectByPrimaryKey(1));
        System.out.println("studentMapper1->"+studentMapper1.selectByPrimaryKey(1));

        studentMapper2.updateStudentName("张二",1);

        System.out.println("studentMapper1->"+studentMapper1.selectByPrimaryKey(1));
        System.out.println("studentMapper2->"+studentMapper2.selectByPrimaryKey(1));
    }

    @Test
    public void cacheTest4() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        StudentMapper studentMapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        System.out.println("studentMapper1->"+studentMapper1.selectByPrimaryKey(1));
        System.out.println("studentMapper2->"+studentMapper2.selectByPrimaryKey(1));
    }

    @Test
    public void cacheTest5() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        StudentMapper studentMapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        System.out.println("studentMapper1->"+studentMapper1.selectByPrimaryKey(1));
        sqlSession1.commit();
        System.out.println("studentMapper2->"+studentMapper2.selectByPrimaryKey(1));
    }

    @Test
    public void cacheTest6() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession3 = sqlSessionFactory.openSession(true);

        StudentMapper studentMapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        StudentMapper studentMapper3 = sqlSession3.getMapper(StudentMapper.class);

        System.out.println("studentMapper1->"+studentMapper1.selectByPrimaryKey(1));
        sqlSession1.commit();
        System.out.println("studentMapper2->"+studentMapper2.selectByPrimaryKey(1));
        studentMapper3.updateStudentName("张二二",1);
        sqlSession3.commit();
        System.out.println("studentMapper2->"+studentMapper2.selectByPrimaryKey(1));
    }

    @Test
    public void cacheTest7() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession3 = sqlSessionFactory.openSession(true);

        StudentMapper studentMapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        ScoreMapper scoreMapper = sqlSession3.getMapper(ScoreMapper.class);

        System.out.println("studentMapper1->"+studentMapper1.selectStudentScore("1","A"));
        sqlSession1.close();
        System.out.println("studentMapper2->"+studentMapper2.selectStudentScore("1","A"));
        scoreMapper.updateScore("1","A",99);
        sqlSession3.commit();
        System.out.println("studentMapper2->"+studentMapper2.selectStudentScore("1","A"));
    }
}
