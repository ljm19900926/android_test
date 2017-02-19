#include<stdio.h>
#include<sys/ioctl.h>
#include<sys/types.h>
#include<fcntl.h>

#define LED_ON _IO('k',0)
#define LED_OFF _IO('k',1)
int main(int argc, const char *argv[])
{
	int fd = open("/dev/led",O_RDWR);
	if(fd<0)
		perror("open failed");
	while(1)
	{
		ioctl(fd,LED_ON);
		sleep(1);
		ioctl(fd,LED_OFF);
		sleep(1);
		printf("fuck world\n");
	}
	return 0;
}
