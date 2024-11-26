cmake_minimum_required(VERSION 3.10)

# 设置项目名称和版本
project(MyProject VERSION 1.0)

# 设置C标准
set(CMAKE_C_STANDARD 11)

# 添加可执行文件
aux_source_directory(./impl SOURCE_FILES)
add_executable(main main.c ${SOURCE_FILES})
target_include_directories(main PRIVATE ./include)