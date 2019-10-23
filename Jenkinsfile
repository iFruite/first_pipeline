pipeline {
  agent any
  stages {
    stage('build') {
      parallel {
        stage('build-backend') {
          steps {
            echo 'build-backend'
          }
        }
        stage('build-frontend') {
          steps {
            echo 'build-frontend'
            dir(path: 'cdm') {
              bat(script: 'mvn clean package', label: 'mvn-cdm-compile')
            }

          }
        }
      }
    }
    stage('test') {
      parallel {
        stage('test-xunit') {
          steps {
            echo 'test-xunit'
          }
        }
        stage('test-api') {
          steps {
            echo 'test-api'
          }
        }
        stage('test-codescan') {
          steps {
            echo 'test-codescan'
            jiraAddComment(idOrKey: '10008', comment: 'abcdefg', input: 'inputddd', auditLog: true)
          }
        }
      }
    }
    stage('deploy') {
      parallel {
        stage('deploy-service') {
          steps {
            echo 'deploy-service'
          }
        }
        stage('deploy-web') {
          steps {
            echo 'deploy-web'
          }
        }
        stage('deploy-app') {
          steps {
            echo 'deploy-app'
          }
        }
        stage('deploy-h5') {
          steps {
            echo 'deploy-h5'
          }
        }
      }
    }
    stage('uat') {
      steps {
        echo 'web-uat'
      }
    }
    stage('monitor') {
      steps {
        echo 'api-monitor'
      }
    }
  }
}